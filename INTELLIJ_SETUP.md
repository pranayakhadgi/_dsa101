# IntelliJ IDEA Setup for Auto-Compilation

## Enable Automatic Compilation

To ensure IntelliJ automatically compiles your Java files when you make changes:

### Step 1: Enable "Build project automatically"
1. Go to `File` → `Settings` (or `Ctrl+Alt+S` / `Cmd+,` on Mac)
2. Navigate to `Build, Execution, Deployment` → `Compiler`
3. Check the box: **"Build project automatically"**
4. Click `Apply` and `OK`

### Step 2: Enable "Compile before running"
1. Go to `File` → `Settings` → `Build, Execution, Deployment` → `Compiler`
2. Check: **"Compile independent modules in parallel"**
3. In the same section, ensure **"Build process heap size"** is at least 700 (or higher)

### Step 3: Verify Run Configuration
When you run a Java file:
1. Right-click on the `.java` file
2. Select `Run 'ClassName'`
3. IntelliJ should automatically compile before running

If it doesn't compile automatically, you can:
- Press `Ctrl+F9` (or `Cmd+F9` on Mac) to manually build
- Or run `./compile.sh` from the terminal

## Quick Fix for Current Issue

If your changes aren't being reflected:

1. **Manual Build**: Press `Ctrl+F9` (Windows/Linux) or `Cmd+F9` (Mac)
2. **Or use the script**: Run `./compile.sh` in terminal
3. **Then run your file again**

## Creating New Java Files

When you create a new Java file in `video-followthrough/Pranaya/`:

1. **Always include the package declaration** at the top:
   ```java
   package Pranaya;
   
   public class YourNewClass {
       // your code
   }
   ```

2. **IntelliJ will automatically compile it** when you run it (if auto-compile is enabled)

3. **You never need to manually create `.class` files** - they're automatically generated in `out/production/Basic_Structures/`

## Troubleshooting

- **"Class not found" error**: Run `./compile.sh` or press `Ctrl+F9` to rebuild
- **Old code still running**: Make sure you've saved the file (`Ctrl+S`) and rebuilt (`Ctrl+F9`)
- **New file not compiling**: Check that it has the correct package declaration matching its folder


