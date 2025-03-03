# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Changed
- major refactoring with breaking changes in main API

- api changed from action result pattern to remote exceptions
  
- introduced `oneway` api calls in the API

### Removed
- removed previously deprecated classes and interfaces:
  + `IntentLogger`
  + `BindingDiedDelegate`
  + `IPluggableServiceConnection`
  + `NullBindingDelegate`
  + `PluggableServiceConnection`
  + `ServiceConnectedDelegate`
  + `ServiceDisconnectedDelegate`
  + `ISharedServiceTagSource`



## [0.0.3] - 2024-11-06

### Changed

- intent created with `ServiceConnectionIntentFactory` contains information about client package, 
from version 1.0.0 of shared library all attempts to connect to service must contain client package name and client identity 

## [0.0.2] - 2024-10-21

### Added

- `getVisibleFov` added to `ISharedService`

### Changed

- migrated to `libs.versions.toml` 

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

- process of building intent used to connect to Inseye Service was streamlined by `ServiceConnectionIntentFactory`. All other ways of connecting to Inseye Service are deprecated and will be removed in `1.0.0`.

## [0.0.1] - 2024-04-23

### Added

- project [changelog](./CHANGELOG.md)

- introduced new endpoint that allows starting calibration procedure that is performed and managed by service

- copyright notice in all source files

- library documentation

### Changed

- errorMessage null checks in [ActionResult](./module/src/main/java/com/inseye/shared/communication/ActionResult.java)
