# Apache Ignite and Spring Data Integration
This is a very simple example for integration between Apache Ignite and Spring Data
### Requirements
To execute correctrly this project we need to have following tools installed in our local environment:
* Java v1.8+
* Gradle v4.5+
* MySQL v5.6+

## Running the Example
### Database
1. Run sql/init.sql on MySQL Database
2. Import data.csv or run inserts.sql on MySQL created database
> Warning! data.csv and inserts.sql contain 500000 records to be imported, it will take some time, fell free to reduce the size of both files to make this faster

### Server
1. Go by command line to the root of the project
2. Execute the following command
`./gradlew bootRun`

### Test
To visualize all available endpoints please use the utility of your preference, above the list of the available urls:

#### Database URLs
* [All available people](http://localhost:8090/person/list)
* [People with specific age](http://localhost:8090/person/list/18)
* [People by social security  number](http://localhost:8090/person/194866)

#### Ignite URLs
* [All available people](http://localhost:8090/person/cache/list)
* [People with specific age](http://localhost:8090/person/cachelist/18)
* [People by social security  number](http://localhost:8090/person/194866)