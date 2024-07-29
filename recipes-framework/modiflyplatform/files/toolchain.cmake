# CMake system name must be something like "Linux".
# This is important for cross-compiling.

set( CMAKE_SYSTEM_NAME Linux )
set( CMAKE_SYSTEM_PROCESSOR aarch64 )
set( CMAKE_C_COMPILER aarch64-poky-linux-gcc )
set( CMAKE_CXX_COMPILER aarch64-poky-linux-g++ )
set( CMAKE_C_COMPILER_LAUNCHER  )
set( CMAKE_CXX_COMPILER_LAUNCHER  )
set( CMAKE_ASM_COMPILER aarch64-poky-linux-gcc )
find_program( CMAKE_AR aarch64-poky-linux-gcc-ar DOC "Archiver" REQUIRED )

set( CMAKE_C_FLAGS " -mcpu=cortex-a57+crc -mbranch-protection=standard -fstack-protector-strong  -O2 -D_FORTIFY_SOURCE=2 -Wformat -Wformat-security -Werror=format-security  --sysroot=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot  -O2 -pipe -g -feliminate-unused-debug-types   -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/git=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/git=/usr/src/debug/modiflyplatform/1.0  -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/build=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/build=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot=  -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot=  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot-native=  --sysroot=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot" CACHE STRING "CFLAGS" )
set( CMAKE_CXX_FLAGS " -mcpu=cortex-a57+crc -mbranch-protection=standard -fstack-protector-strong  -O2 -D_FORTIFY_SOURCE=2 -Wformat -Wformat-security -Werror=format-security  --sysroot=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot  -O2 -pipe -g -feliminate-unused-debug-types   -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/git=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/git=/usr/src/debug/modiflyplatform/1.0  -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/build=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/build=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot=  -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot=  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot-native=  -fvisibility-inlines-hidden --sysroot=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot" CACHE STRING "CXXFLAGS" )
set( CMAKE_ASM_FLAGS " -mcpu=cortex-a57+crc -mbranch-protection=standard -fstack-protector-strong  -O2 -D_FORTIFY_SOURCE=2 -Wformat -Wformat-security -Werror=format-security  --sysroot=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot  -O2 -pipe -g -feliminate-unused-debug-types   -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/git=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/git=/usr/src/debug/modiflyplatform/1.0  -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/build=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/build=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot=  -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot=  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot-native=  --sysroot=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot" CACHE STRING "ASM FLAGS" )
set( CMAKE_C_FLAGS_RELEASE "-DNDEBUG" CACHE STRING "Additional CFLAGS for release" )
set( CMAKE_CXX_FLAGS_RELEASE "-DNDEBUG" CACHE STRING "Additional CXXFLAGS for release" )
set( CMAKE_ASM_FLAGS_RELEASE "-DNDEBUG" CACHE STRING "Additional ASM FLAGS for release" )
set( CMAKE_C_LINK_FLAGS " -mcpu=cortex-a57+crc -mbranch-protection=standard -fstack-protector-strong  -O2 -D_FORTIFY_SOURCE=2 -Wformat -Wformat-security -Werror=format-security  --sysroot=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot  -Wl,-O1 -Wl,--hash-style=gnu -Wl,--as-needed   -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/git=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/git=/usr/src/debug/modiflyplatform/1.0  -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/build=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/build=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot=  -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot=  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot-native=  -Wl,-z,relro,-z,now" CACHE STRING "LDFLAGS" )
set( CMAKE_CXX_LINK_FLAGS " -mcpu=cortex-a57+crc -mbranch-protection=standard -fstack-protector-strong  -O2 -D_FORTIFY_SOURCE=2 -Wformat -Wformat-security -Werror=format-security  --sysroot=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot  -O2 -pipe -g -feliminate-unused-debug-types   -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/git=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/git=/usr/src/debug/modiflyplatform/1.0  -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/build=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/build=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot=  -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot=  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot-native=  -fvisibility-inlines-hidden --sysroot=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot -Wl,-O1 -Wl,--hash-style=gnu -Wl,--as-needed   -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/git=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/git=/usr/src/debug/modiflyplatform/1.0  -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/build=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/build=/usr/src/debug/modiflyplatform/1.0  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot=  -fmacro-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot=  -fdebug-prefix-map=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot-native=  -Wl,-z,relro,-z,now" CACHE STRING "LDFLAGS" )

# only search in the paths provided so cmake doesnt pick
# up libraries and tools from the native build machine
set( CMAKE_FIND_ROOT_PATH /opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot /opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot-native     /opt/yocto/poky/build/tmp/hosttools)
set( CMAKE_FIND_ROOT_PATH_MODE_PACKAGE ONLY )
set( CMAKE_FIND_ROOT_PATH_MODE_PROGRAM ONLY )
set( CMAKE_FIND_ROOT_PATH_MODE_LIBRARY ONLY )
set( CMAKE_FIND_ROOT_PATH_MODE_INCLUDE ONLY )
set( CMAKE_PROGRAM_PATH "/" )

set( CMAKE_SYSROOT "/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot" )

# Use qt.conf settings
set( ENV{QT_CONF_PATH} /opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/qt.conf )

# We need to set the rpath to the correct directory as cmake does not provide any
# directory as rpath by default
set( CMAKE_INSTALL_RPATH  )

# Use RPATHs relative to build directory for reproducibility
set( CMAKE_BUILD_RPATH_USE_ORIGIN ON )

# Use our cmake modules
list(APPEND CMAKE_MODULE_PATH "/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot/usr/share/cmake/Modules/")

# add for non /usr/lib libdir, e.g. /usr/lib64
set( CMAKE_LIBRARY_PATH /usr/lib /usr/lib)

# add include dir to implicit includes in case it differs from /usr/include
list(APPEND CMAKE_C_IMPLICIT_INCLUDE_DIRECTORIES /usr/include)
list(APPEND CMAKE_CXX_IMPLICIT_INCLUDE_DIRECTORIES /usr/include)

