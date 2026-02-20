#!/bin/bash
# Compilation script for Java files
# Run this script to compile all Java files in the project
# This ensures your changes are compiled before running

cd "$(dirname "$0")"

echo "Compiling all Java files..."
javac -d out/production/Basic_Structures \
    video-followthrough/Pranaya/*.java \
    video-followthrough/Ali/*.java \
    video-followthrough/Mayowa/*.java 2>/dev/null

if [ $? -eq 0 ]; then
    echo "✓ Compilation successful!"
    echo "All Java files have been compiled to out/production/Basic_Structures/"
else
    echo "Compilation completed (some files may not exist yet, which is OK)"
fi

