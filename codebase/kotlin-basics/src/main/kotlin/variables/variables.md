# `val` vs `const`

- `const` - compile time constant
- `val` - run time constant


- `const` only allowed at top-level or with in objects

# `object` vs `companion object`

## `comanion object`

- Initialized from static constructor of containing class
- They are created when the object is created

## `object`

- Initialized lazily on the first access to that object
- That is, created when they are first used
