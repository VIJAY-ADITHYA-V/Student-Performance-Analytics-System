#!/bin/bash

# Build and Verification Script for Student Performance Analytics System
# This script verifies the application is compatible with Jenkins integration

echo "=========================================="
echo "Build and Verification Script"
echo "=========================================="

# Check Java version
echo ""
echo "--- Checking Java Version ---"
java -version

# Check Maven version
echo ""
echo "--- Checking Maven Version ---"
mvn --version

# Clean previous builds
echo ""
echo "--- Cleaning Previous Builds ---"
mvn clean

# Compile source code
echo ""
echo "--- Compiling Source Code ---"
mvn compile
if [ $? -ne 0 ]; then
    echo "ERROR: Compilation failed!"
    exit 1
fi

# Run unit tests
echo ""
echo "--- Running Unit Tests ---"
mvn test
if [ $? -ne 0 ]; then
    echo "ERROR: Tests failed!"
    exit 1
fi

# Package application
echo ""
echo "--- Packaging Application ---"
mvn package
if [ $? -ne 0 ]; then
    echo "ERROR: Packaging failed!"
    exit 1
fi

# Verify JAR file exists
echo ""
echo "--- Verifying JAR File ---"
if [ -f "target/StudentPerformanceAnalytics-1.0-SNAPSHOT.jar" ]; then
    echo "SUCCESS: JAR file created successfully!"
    echo "Location: target/StudentPerformanceAnalytics-1.0-SNAPSHOT.jar"
else
    echo "ERROR: JAR file not found!"
    exit 1
fi

# Check test results
echo ""
echo "--- Test Results Summary ---"
if [ -d "target/surefire-reports" ]; then
    echo "Test reports available in: target/surefire-reports/"
    ls -la target/surefire-reports/
fi

# Display build info
echo ""
echo "=========================================="
echo "Build Information"
echo "=========================================="
echo "Build Date: $(date)"
echo "Build Directory: $(pwd)"
echo "JAR File Size: $(du -h target/StudentPerformanceAnalytics-1.0-SNAPSHOT.jar | cut -f1)"

echo ""
echo "=========================================="
echo "✓ Build and Verification SUCCESSFUL!"
echo "=========================================="
echo ""
echo "Application is ready for Jenkins integration."
echo "Jenkins can now build and deploy this application."
echo ""