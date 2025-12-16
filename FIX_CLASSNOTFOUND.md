# Fix: ClassNotFoundException in IntelliJ

## The Problem
IntelliJ can't find `Pranaya.array_Main` even though the class files exist in `out/production/Basic_Structures/`.

## Solution Steps (Do These in Order)

### Step 1: Rebuild Project in IntelliJ
1. In IntelliJ, go to `Build` → `Rebuild Project`
2. Wait for it to complete
3. This will recompile everything and update IntelliJ's index

### Step 2: Invalidate Caches and Restart
1. Go to `File` → `Invalidate Caches / Restart...`
2. Select **"Invalidate and Restart"**
3. This clears IntelliJ's cached information about your project

### Step 3: Verify Module Configuration
1. Right-click on `Basic_Structures.iml` in the project
2. Select `Open Module Settings` (or `File` → `Project Structure`)
3. Go to `Modules` → `Basic_Structures`
4. Under `Paths`, verify:
   - **Output path**: `$MODULE_DIR$/out/production/Basic_Structures`
   - **Test output path**: `$MODULE_DIR$/out/test/Basic_Structures`
5. Click `OK`

### Step 4: Check Run Configuration
1. Click the run configuration dropdown (top right)
2. Select `Edit Configurations...`
3. Find `array_Main`
4. Verify:
   - **Module**: `Basic_Structures` (should be selected)
   - **Main class**: `Pranaya.array_Main`
   - **Working directory**: `$PROJECT_DIR$`
5. Under "Before launch", make sure **"Build"** is checked
6. Click `OK`

### Step 5: Manual Build and Run
1. Press `Ctrl+F9` (or `Cmd+F9` on Mac) to build
2. Check the "Build" tool window at the bottom - it should show "Build completed successfully"
3. Now try running the file again

### Step 6: If Still Not Working - Use Terminal
If IntelliJ still can't find the class, use the terminal:

```bash
# Compile
./compile.sh

# Run
java -cp out/production/Basic_Structures Pranaya.array_Main
```

## Why This Happens

IntelliJ maintains an internal index of your project. Sometimes this index gets out of sync with the actual files. The steps above force IntelliJ to:
1. Rebuild the project structure
2. Clear cached information
3. Re-index everything

## Prevention

After making changes to Java files:
1. **Always save** (`Ctrl+S`)
2. **Let IntelliJ auto-compile** (if enabled) or press `Ctrl+F9`
3. **Check the Build tool window** to ensure compilation succeeded
4. Then run your file

