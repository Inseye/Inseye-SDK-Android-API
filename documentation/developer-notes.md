# Developer notes
If Inseye bound service package name or intent action name changes then adequate changes must be made in `manifestes/AndroidManifest.xml` and in `res/values/strings.xml`.

You can check client and service compatibility by analyzing both client and service apk (`Build -> Analyze APK...` in Android studio).
Remember that package name in service application `Manifest.xml` is overwritten with `applicationId` from `build.gradle`. 

## Backward compatibility rules
To keep backward compatibility in AIDL interfaces abide the rules bellow:
1. All public interfaces must have explicitly numbered methods.
2. Interface method signature (number of input and output arguments and their type) must not change. Method names can change but must keep the same method number.
3. Types passed trough API must be byte compatible:
   + fields layout must be kept
   + each field size (and type) must not change
   + new fields must be added at the end of type
   + if some field of type is not used by new interface implementation then it should have some 'sane' or default value assigned