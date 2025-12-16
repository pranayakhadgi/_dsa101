# Quick Fix: Make IntelliJ Compile Before Running

## The Problem
When you make changes to your Java files, IntelliJ is running the old compiled version from the `out/` folder instead of recompiling your changes.

## The Solution (3 Steps)

### Step 1: Reload IntelliJ Project
1. Close IntelliJ IDEA completely
2. Reopen the project
3. This will load the updated configuration that compiles before running

### Step 2: Verify Run Configuration
1. Click on the run configuration dropdown (top right, next to the green play button)
2. Select "Edit Configurations..."
3. Find "array_Main" in the list
4. Make sure "Build" is checked under "Before launch" section
5. Click "OK"

### Step 3: Test It
1. Make a change to `video-followthrough/Pranaya/array_Main.java`
2. Save the file (`Ctrl+S`)
3. Click the green Run button (or press `Shift+F10`)
4. IntelliJ should automatically compile and run your updated code

## Alternative: Manual Build Before Run

If automatic compilation still doesn't work:

1. **Before running**, press `Ctrl+F9` (Windows/Linux) or `Cmd+F9` (Mac) to build
2. Then run your file

Or use the terminal:
```bash
./compile.sh
```

## For New Files You Create

When you create a new Java file in `video-followthrough/Pranaya/`:

1. **Always include the package**: `package Pranaya;` at the top
2. **Save the file** (`Ctrl+S`)
3. **Press `Ctrl+F9`** to build (or let IntelliJ auto-compile)
4. **Run it** - it will work!

**You NEVER need to manually create files in the `out/` folder** - they're automatically generated when you compile.

## Still Not Working?

1. Go to `File` → `Invalidate Caches / Restart...`
2. Select "Invalidate and Restart"
3. This will clear any cached compilation issues


