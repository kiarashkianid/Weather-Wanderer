# CSC207 Project: Canada Province Comparison Tool

**Statistics Canada API:** [https://www.statcan.gc.ca/en/microdata/api]

**Project Discord:** [ Discord ](https://discord.gg/Vnf28JWz)

## Problem Domain

Our team aims to develop an application that assists users interested in immigrating to Canada by providing a comparison tool for different provinces. This tool is based on a model that calculates immigration scores for each province using data from the Statistics Canada API.

## Application Description

Our application will offer users a user-friendly interface to input their preferences, including importance scores for multiple variables such as the economic status of the province, education, healthcare, and more, for immigration to Canada. The application will then gather relevant data from the Statistics Canada API to calculate an immigration score for each province. These scores will be used to provide recommendations on which province might be the best fit for the user's needs.

## API Documentation

We will utilize the [Statistics Canada API](https://www.statcan.gc.ca/eng/developers/wds/rest) to access demographic and economic data for Canadian provinces.

## Example Calls to API and Data Output
<img width="1494" alt="Screen Shot 2023-09-28 at 9 13 16 PM" src="https://github.com/kiarashkianid/CSC207-project/assets/145369644/e31685ef-1685-4a46-a35a-ec46db51a515">

<img width="878" alt="Screen Shot 2023-09-28 at 9 13 40 PM" src="https://github.com/kiarashkianid/CSC207-project/assets/145369644/dba9a1f0-23f4-4106-a80e-f5546d555718">

## Example Java Code Calling the API

Located in: "src/main/java/api/StatsCanada.java". Modelled after the Grade API lab activity, using OkHttp.


## Some possible technical challenges that might block progress
- Not exactly a technical issue; our 4th member, Matthew MacQuarrie-Cottle has been unable to join the repository as a collaborator yet, we will get this sorted on Monday. 
- one of the possible challenges is data management and processing from an API that is updating over time
- Learning curve of extracting the data from the API & getting it into IntelliJ (our test API sample call only checks for if the call was successful; we aren't quite sure how to extract the data yet.)


