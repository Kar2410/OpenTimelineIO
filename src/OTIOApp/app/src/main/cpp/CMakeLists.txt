# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
        jotio

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        io_opentimeline_OTIOFinalizer.cpp
        otio_manager.cpp
        class_codes.cpp
        utilities.cpp
        io_opentimeline_opentime_ErrorStatus.cpp
        io_opentimeline_OTIONative.cpp
        io_opentimeline_opentime_RationalTime.cpp
        io_opentimeline_opentime_TimeRange.cpp
        io_opentimeline_opentime_TimeTransform.cpp
        io_opentimeline_opentimelineio_Any.cpp
        io_opentimeline_opentimelineio_AnyDictionary.cpp
        io_opentimeline_opentimelineio_AnyDictionary_Iterator.cpp
        io_opentimeline_opentimelineio_AnyVector.cpp
        io_opentimeline_opentimelineio_AnyVector_Iterator.cpp
        io_opentimeline_opentimelineio_ErrorStatus.cpp
        io_opentimeline_opentimelineio_SerializableObject.cpp
        io_opentimeline_opentimelineio_SerializableObjectWithMetadata.cpp
        io_opentimeline_opentimelineio_SerializableCollection.cpp
        io_opentimeline_opentimelineio_Marker.cpp
        io_opentimeline_opentimelineio_MediaReference.cpp
        io_opentimeline_opentimelineio_MissingReference.cpp
        io_opentimeline_opentimelineio_ExternalReference.cpp
        io_opentimeline_opentimelineio_GeneratorReference.cpp
        io_opentimeline_opentimelineio_Effect.cpp
        io_opentimeline_opentimelineio_TimeEffect.cpp
        io_opentimeline_opentimelineio_LinearTimeWarp.cpp
        io_opentimeline_opentimelineio_FreezeFrame.cpp
        io_opentimeline_opentimelineio_ImageSequenceReference.cpp
        io_opentimeline_opentimelineio_Composable.cpp
        io_opentimeline_opentimelineio_Item.cpp
        io_opentimeline_opentimelineio_Composition.cpp
        io_opentimeline_opentimelineio_Gap.cpp
        io_opentimeline_opentimelineio_UnknownSchema.cpp
        io_opentimeline_opentimelineio_Transition.cpp
        io_opentimeline_opentimelineio_Clip.cpp
        io_opentimeline_opentimelineio_Stack.cpp
        io_opentimeline_opentimelineio_Track.cpp
        io_opentimeline_opentimelineio_Timeline.cpp
        io_opentimeline_opentimelineio_Algorithms.cpp
        io_opentimeline_opentimelineio_Serialization.cpp
        io_opentimeline_opentimelineio_Deserialization.cpp
        io_opentimeline_opentimelineio_OTIOTest.cpp
        io_opentimeline_OTIOFinalizer.h
        otio_manager.h
        class_codes.h
        utilities.h
        io_opentimeline_opentime_ErrorStatus.h
        io_opentimeline_OTIONative.h
        io_opentimeline_opentime_RationalTime.h
        io_opentimeline_opentime_TimeRange.h
        io_opentimeline_opentime_TimeTransform.h
        io_opentimeline_opentimelineio_Any.h
        io_opentimeline_opentimelineio_AnyDictionary.h
        io_opentimeline_opentimelineio_AnyDictionary_Iterator.h
        io_opentimeline_opentimelineio_AnyVector.h
        io_opentimeline_opentimelineio_AnyVector_Iterator.h
        io_opentimeline_opentimelineio_ErrorStatus.h
        io_opentimeline_opentimelineio_SerializableObject.h
        io_opentimeline_opentimelineio_SerializableObjectWithMetadata.h
        io_opentimeline_opentimelineio_SerializableCollection.h
        io_opentimeline_opentimelineio_Marker.h
        io_opentimeline_opentimelineio_MediaReference.h
        io_opentimeline_opentimelineio_MissingReference.h
        io_opentimeline_opentimelineio_ExternalReference.h
        io_opentimeline_opentimelineio_GeneratorReference.h
        io_opentimeline_opentimelineio_Effect.h
        io_opentimeline_opentimelineio_TimeEffect.h
        io_opentimeline_opentimelineio_LinearTimeWarp.h
        io_opentimeline_opentimelineio_FreezeFrame.h
        io_opentimeline_opentimelineio_ImageSequenceReference.h
        io_opentimeline_opentimelineio_Composable.h
        io_opentimeline_opentimelineio_Item.h
        io_opentimeline_opentimelineio_Composition.h
        io_opentimeline_opentimelineio_Gap.h
        io_opentimeline_opentimelineio_UnknownSchema.h
        io_opentimeline_opentimelineio_Transition.h
        io_opentimeline_opentimelineio_Clip.h
        io_opentimeline_opentimelineio_Stack.h
        io_opentimeline_opentimelineio_Track.h
        io_opentimeline_opentimelineio_Timeline.h
        io_opentimeline_opentimelineio_Algorithms.h
        io_opentimeline_opentimelineio_Serialization.h
        io_opentimeline_opentimelineio_Deserialization.h
        io_opentimeline_opentimelineio_OTIOTest.h)

target_include_directories(jotio PUBLIC
        "${PROJECT_SOURCE_DIR}")
add_subdirectory(../../../../../.. ../../../build/native)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        jotio

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})
target_link_libraries(jotio opentime)
target_link_libraries(jotio opentimelineio)