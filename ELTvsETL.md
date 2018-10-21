# **ETL**
-   Extraction  (from source to staging area)
-   Transformation (reformatted for datawarehouse purpose)
-   Loaded  (from staging area into datawarehous)

![ETL process](images/ETL.png)
## ETL == Pipeline approach

Many tools available: DataStage, Informatica, or SQL Server Integration Services (SSIS)
All work in a similair way: read from source, perform changes, write to target
ETL steps can be performed multiple times for a particulair load.
Transformation step can add business logic
Also everything is done in one single step.

An ETL process should have data flowing steadily through it. Risk of running out of memory and/or disk space. (sorting is a classic example - holds entire dataset - if already sorted then rightaway in datawarehouse) Should have the possibility of buffering in pipeline.

Many ETL tools facilitate parallel execution == multiple pipelines.
ETL can be better performing, but needs more training and developement cost.



# **ELT**
Target system is performing the transformation.
![ELT process](images/ELT.png)
## ELT == NO transformation engine

ETL or ELT?? Depends on priorities.

ELT is requires a powerful system in place as target. More such systems available because of analytics.

ie a perfect platform is Hadoop but needs carefully planning
