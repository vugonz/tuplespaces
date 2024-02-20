# TupleSpaces

Distributed Systems Project 2024


<!-- *(fill the line below with the group identifier, for example A25 or T25, and then delete this line)*   -->
**Group GA34**

<!-- *(choose one of the following levels and erase the other one)*   -->
**Difficulty level: I am Death incarnate!**


### Code Identification

In all source files (namely in the *groupId*s of the POMs), replace __GXX__ with your group identifier. The group
identifier consists of either A or T followed by the group number - always two digits. This change is important for 
code dependency management, to ensure your code runs using the correct components and not someone else's.

### Team Members

<!-- *(fill the table below with the team members, and then delete this line)* -->

| Number | Name              | User                             | Email                               |
|--------|-------------------|----------------------------------|-------------------------------------|
| 93075  | Gonçalo Azevedo  | <https://github.com/gazev>   | <mailto:goncalo.r.azevedo@tecnico.ulisboa.pt>   |
| 99986  | João Tiago       | <https://github.com/jmlt2002>     | <mailto:joao.leal.tintas@tecnico.ulisboa.pt>     |
| 103156  | Francisco Nael Salgado     | <https://github.com/fnael> | <mailto:francisco.nael.salgado@tecnico.ulisboa.pt> |

## Getting Started

The overall system is made up of several modules. The different types of servers are located in _ServerX_ (where X denotes stage 1, 2 or 3). 
The clients is in _Client_.
The definition of messages and services is in _Contract_. The future naming server
is in _NamingServer_.

See the [Project Statement](https://github.com/tecnico-distsys/TupleSpaces) for a complete domain and system description.

### Prerequisites

The Project is configured with Java 17 (which is only compatible with Maven >= 3.8), but if you want to use Java 11 you
can too -- just downgrade the version in the POMs.

To confirm that you have them installed and which versions they are, run in the terminal:

```s
javac -version
mvn -version
```

### Installation

To compile and install all modules:

```s
mvn clean install
```

## Built With

* [Maven](https://maven.apache.org/) - Build and dependency management tool;
* [gRPC](https://grpc.io/) - RPC framework.

