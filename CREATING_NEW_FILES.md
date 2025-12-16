# Creating New Java Files - Quick Guide

## Common Mistakes to Avoid

When creating a new Java file, make sure:

1. **`main` method is lowercase** - not `Main`
   ```java
   public static void main(String[] args)  // ✓ Correct
   public static void Main(String[] args)  // ✗ Wrong
   ```

2. **`String` has capital S** - not `string`
   ```java
   String[] args  // ✓ Correct
   string[] args  // ✗ Wrong
   ```

3. **Always include the package declaration** at the top
   ```java
   package Pranaya;  // Must match your folder name
   ```

## Quick Template

When creating a new file in `video-followthrough/Pranaya/`, use this template:

```java
package Pranaya;

public class YourClassName {
    public static void main(String[] args) {
        // Your code here
    }
}
```

## Steps to Create a New File

1. **Right-click** on `video-followthrough/Pranaya/` folder in IntelliJ
2. Select **`New` → `Java Class`**
3. Enter the class name (e.g., `MyNewClass`)
4. IntelliJ will create the file, but you need to:
   - Add `package Pranaya;` at the top
   - Add the `main` method if you want to run it

## Or Copy the Template

1. Copy `_Template.java` in the Pranaya folder
2. Rename it to your desired class name
3. Change the class name inside the file to match
4. Add your code

## After Creating the File

1. **Save** the file (`Ctrl+S`)
2. **Build** the project (`Ctrl+F9`) or let IntelliJ auto-compile
3. **Run** the file (right-click → `Run 'ClassName'`)

## Troubleshooting

- **"Cannot resolve symbol 'string'"**: Change `string` to `String` (capital S)
- **"Cannot resolve symbol 'Main'"**: Change `Main` to `main` (lowercase)
- **"Class not found"**: Make sure you have `package Pranaya;` at the top
- **File not executable**: Make sure you have a `main` method with correct signature

