# Toolchain file for host builds

# Specify the compilers for the host build
set(CMAKE_C_COMPILER ${CMAKE_C_COMPILER} CACHE STRING "Host C compiler" FORCE)
set(CMAKE_CXX_COMPILER ${CMAKE_CXX_COMPILER} CACHE STRING "Host C++ compiler" FORCE)

# Other toolchain settings, if needed

# Specify the toolchain file
if (NOT CMAKE_CROSSCOMPILING)
    set(CMAKE_TOOLCHAIN_FILE "${CMAKE_SOURCE_DIR}/host-toolchain.cmake")
endif()
