# HVA application 

* Core: `hva-core` contains the domain classes
* Interaction: `hva-app` contains the user interaction classes
* UML diagrams: `uml` contain the diagrams from the first delivery ( It's not fully accurate with the project itself)

# Veterinary Hotel Management System

🏨🦁 Veterinary Hotel Management System for Object-Oriented Programming made in Java 22 🐾🌳

## Introduction

This project implements a comprehensive management system for a veterinary hotel where habitats, animals, and personnel such as keepers and veterinarians are managed. Created for the Object-Oriented Programming course, the system manages various entities and calculates satisfaction scores, maintaining records on animal well-being, employee responsibilities, habitats, trees, and vaccinations.

## Features

- **Animal Management**: Register, view, transfer, and calculate satisfaction scores for animals.
- **Employee Management**: Register and manage responsibilities for keepers and veterinarians, with satisfaction levels calculated based on workload and expertise.
- **Habitat Management**: Define and modify habitats, adjust influence on species, and plant trees.
- **Tree Lifecycle and Maintenance**: Track and manage seasonal effects on deciduous and evergreen trees, calculate cleaning efforts, and account for age-related changes.
- **Vaccination Management**: Record and manage vaccinations, assess potential health impacts from incorrect administration.
- **File Import and Export**: Initialize with predefined data, save and load system states via serialization.

## Menus and Commands

The system provides a user-friendly menu-driven interface with the following main menus:

- **Main Menu**: Access options to save/load states, progress through seasons, and view global satisfaction.
- **Animal Management**: View all animals, register new animals, transfer to habitats, and check satisfaction.
- **Employee Management**: View all employees, add/remove responsibilities, and calculate employee satisfaction.
- **Habitat Management**: List all habitats, add new habitats, adjust area and species influence, plant trees, and view all trees in a habitat.
- **Vaccination Management**: List, register, and administer vaccines; view vaccination history.
- **Consultation**: Query animals in habitats, vaccine details, medical acts, and record errors due to incorrect vaccinations.

## Satisfaction Calculations

The system includes satisfaction algorithms for both animals and employees:

- **Animal Satisfaction**: Based on species, population, habitat size, and compatibility.
- **Veterinarian Satisfaction**: Influenced by the number of colleagues sharing the responsibility and the workload from animals.
- **keeper Satisfaction**: Reflects workload based on habitat size, animal count, and cleaning effort from trees.

## Execution

To run and test the program, the system supports command-line execution with input and output comparisons:

```sh
java -Dimport=test.import -Din=test.in -Dout=test.outhyp hva.app.App
diff -b test.out test.outhyp
