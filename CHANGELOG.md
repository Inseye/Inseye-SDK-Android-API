# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).
## [Unreleased]

### Added


### Deprecated

- deprecated and marked for removal all classes that are not mandatory part of the library, they will be removed in `1.0.0`:
  + `IntentLogger`
  + `BindingDiedDelegate`
  + `IPluggableServiceConnection`
  + `NullBindingDelegate`
  + `PluggableServiceConnection`
  + `ServiceConnectedDelegate`
  + `ServiceDisconnectedDelegate`
  + `ISharedServiceTagSource`

## [0.0.1] - 2024-04-23

### Added

- project [changelog](./CHANGELOG.md)

- introduced new endpoint that allows starting calibration procedure that is performed and managed by service

- copyright notice in all source files

- library documentation

### Changed

- errorMessage null checks in [ActionResult](./module/src/main/java/com/inseye/shared/communication/ActionResult.java)
