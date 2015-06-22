# Biblioteca
Biblioteca is a Library Management System for Bangalore Public Library. The current release of Biblioteca doesn't have any GUI. It is a fully functional command-line application.

## Features
* Seperate user accounts for each user
* List Books and Movies
* Checkout Books and Movies
* Return Books and Movies
* View checkout history (only for librarian)

## Building, Compiling and Running
* This project uses `ant` for automating the project build
* `ant -p` shows the list of options supported by `ant`
* `ant test` execute the project specifications (tests)
* `ant jar` generates a jar file that can be used to start the application
* `ant compile` compiles the source
* `ant compileTests` compile all the tests
* `ant run` runs the application
* The application can also be started using the generated jar file
`java -jar out/jar/EntryPoint.jar`

## Test Users
### Librarian
Library Number: B1011  
Password: passwd
### Member
Library Number: B1012  
Password: password