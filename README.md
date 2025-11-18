# Football Zone API ⚽🏟️

A RESTful API for managing football player data, built with Spring Boot and JPA. This application provides a complete backend solution for storing, retrieving, and managing player statistics including ratings, positions, nationality, and market values. ⚡

## What This API Does 🎯

The Football Zone API allows you to perform full CRUD operations on player data. You can retrieve all players in the database 📋, search for specific players by name or nationality 🔍, filter players by multiple criteria like nationality and position 🌍, and manage player records through creation, updates, and deletion. ✨

The API is designed with a clean three-layer architecture 🏗️: the entity layer defines the player data model with fields like full name, birth date, positions, overall rating, and market value. The repository layer handles all database interactions using Spring Data JPA with custom query methods 💾. The service layer contains business logic including input validation and error handling 🛡️. Finally, the controller layer exposes RESTful endpoints that respond with appropriate HTTP status codes. 🌐

## Key Features 🌟

Search functionality supports partial matching with case-insensitive queries 🔎, making it easy to find players even with incomplete information. The filtering system allows you to narrow down results by combining nationality and position criteria 🎛️. All endpoints return proper HTTP status codes - 200 for success ✅, 201 for creation 🆕, 204 for deletion 🗑️, 404 when resources aren't found ❌, and 409 for conflicts ⚠️.

Error handling is comprehensive with a global exception handler 🚨 that catches issues like missing players, duplicate entries, and validation errors, returning meaningful JSON error responses with timestamps. Input validation ensures data integrity before it reaches the database. 🔒

## Technical Implementation 💻

The project uses Lombok to reduce boilerplate code ✂️, making the codebase cleaner and more maintainable. Constructor injection is used throughout for better testability 💉. The repository extends JpaRepository providing built-in methods plus custom queries like finding players by nationality or searching names with partial matches. 🎪

Transaction management is properly configured ⚙️, especially for delete operations that require the Transactional annotation. The service layer validates all inputs, checks for null or empty values, and throws appropriate exceptions when operations fail. 🎯

## Architecture Improvements 🔧

Several critical improvements were made to ensure production-ready quality. The primary key was changed from a String-based full name to an auto-generated Long ID 🔑, preventing issues with duplicate names and name changes. The repository generic type was corrected to match the entity's ID type, avoiding runtime errors. 🐛

Database queries were optimized by removing inefficient stream operations that loaded all players into memory 📊. Instead, database-level filtering is used through repository methods. The date field was changed from String to LocalDate for proper date handling and age calculation. 📅

Exception handling was centralized using ControllerAdvice 🎪, providing consistent error responses across all endpoints. The service annotation was corrected from the generic Component to the more semantic Service annotation, improving code clarity. 📝

## How To Use 🚀

After configuration, the API runs on localhost port 8080 with a base path of /api/v1/players. You can get all players by sending a GET request to the base endpoint 📥. To find a specific player, append the player's ID to the URL. 🎯 

Search operations use query parameters 🔍 - searching by name uses /search/name with a query parameter, while nationality searches use /search/nationality. For more complex filtering combining nationality and position, use the /filter endpoint with multiple query parameters. 🎛️

Creating a new player requires a POST request with a JSON body containing player details ➕. Updating uses PUT with the player ID in the URL and the updated data in the body ✏️. Deletion is a simple DELETE request with the player ID. 🗑️

The API handles edge cases gracefully 🤝, returning empty arrays for searches with no results and proper error messages when operations fail. All string comparisons are case-insensitive, and partial matches are supported in search operations. 🎉
