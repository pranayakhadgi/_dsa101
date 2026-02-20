#!/bin/bash
# Verification script to check if everything is set up correctly

cd "$(dirname "$0")"

echo "=== Checking Java Setup ==="
echo "Java version:"
java -version 2>&1 | head -1
echo ""

echo "=== Checking Source Files ==="
if [ -f "video-followthrough/Pranaya/array_Main.java" ]; then
    echo "✓ Source file exists: video-followthrough/Pranaya/array_Main.java"
    echo "  Package declaration:"
    grep "^package" video-followthrough/Pranaya/array_Main.java || echo "  ⚠ WARNING: No package declaration found!"
else
    echo "✗ Source file NOT found!"
fi
echo ""

echo "=== Checking Compiled Classes ==="
if [ -f "out/production/Basic_Structures/Pranaya/array_Main.class" ]; then
    echo "✓ Compiled class exists: out/production/Basic_Structures/Pranaya/array_Main.class"
    echo "  File size: $(stat -c%s out/production/Basic_Structures/Pranaya/array_Main.class) bytes"
    echo "  Last modified: $(stat -c%y out/production/Basic_Structures/Pranaya/array_Main.class | cut -d'.' -f1)"
else
    echo "✗ Compiled class NOT found!"
    echo "  Running compilation..."
    ./compile.sh
fi
echo ""

echo "=== Testing Execution ==="
if java -cp out/production/Basic_Structures Pranaya.array_Main 2>&1; then
    echo "✓ Execution successful!"
else
    echo "✗ Execution failed!"
    echo ""
    echo "Trying to recompile..."
    ./compile.sh
    echo ""
    echo "Trying again..."
    java -cp out/production/Basic_Structures Pranaya.array_Main
fi
echo ""

echo "=== IntelliJ Configuration Check ==="
if [ -f "Basic_Structures.iml" ]; then
    echo "✓ Module file exists"
    if grep -q "out/production/Basic_Structures" Basic_Structures.iml; then
        echo "✓ Output path configured correctly"
    else
        echo "✗ Output path NOT configured!"
    fi
else
    echo "✗ Module file NOT found!"
fi
echo ""

echo "=== Summary ==="
echo "If everything shows ✓, the setup is correct."
echo "If IntelliJ still can't find the class, try:"
echo "  1. Build → Rebuild Project in IntelliJ"
echo "  2. File → Invalidate Caches / Restart"
echo "  3. File → Project Structure → Modules → Check output paths"

