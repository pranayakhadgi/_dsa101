# New Java File Checklist

## ✅ Before Creating a New File

When you create a new Java file in `video-followthrough/Pranaya/`, make sure:

### 1. Package Declaration (REQUIRED)
```java
package Pranaya;
```
- Must be the first line (after any imports)
- Must match your folder name exactly

### 2. Main Method (if you want to run it)
```java
public static void main(String[] args) {
    // Your code
}
```

**Common Mistakes:**
- ❌ `Main` (capital M) → ✅ `main` (lowercase)
- ❌ `string` (lowercase) → ✅ `String` (capital S)
- ❌ Missing `[]` → ✅ `String[] args`

### 3. Class Name
- Should match the filename
- Should start with capital letter (Java convention)

## Quick Copy-Paste Template

```java
package Pranaya;

public class YourClassName {
    public static void main(String[] args) {
        // Your code here
    }
}
```

## After Creating File

1. ✅ Save (`Ctrl+S`)
2. ✅ Build (`Ctrl+F9`) - or let IntelliJ auto-compile
3. ✅ Run (right-click → `Run 'ClassName'`)

## Using IntelliJ Template (Recommended)

1. Right-click on `Pranaya` folder
2. `New` → `Java Class`
3. Enter class name
4. IntelliJ will create it with the template (includes package and main method)

## Troubleshooting

| Error | Fix |
|-------|-----|
| `Cannot resolve symbol 'string'` | Change to `String` (capital S) |
| `Cannot resolve symbol 'Main'` | Change to `main` (lowercase) |
| `Class not found` | Add `package Pranaya;` at top |
| `File not executable` | Add `main` method with correct signature |

