# CSC207 Project: Canada Province Comparison Tool

**Statistics Canada API:** [https://www.statcan.gc.ca/en/microdata/api]

**Project Discord:** [ Discord ](https://discord.gg/Vnf28JWz)

## Problem Domain

Our team aims to develop an application that assists users interested in immigrating to Canada by providing a comparison tool for different provinces. This tool is based on a model that calculates immigration scores for each province using data from the Statistics Canada API.

## Application Description

Our application will offer users a user-friendly interface to input their current cities of interest for immigration and provide them with a comparison tool based on their own preferences for perfect weather conditions (weighting variables that form the basis of our calculation of the perfect weather). The application will then gather relevant data from the OpenWeather API to calculate a perfect weather score for each city of interest and display it graphically based on our existing model in a way that is meaningful to the user. These scores will be used to offer recommendations on which one of the cities of interest might be the best fit for the user's needs. Additionally, this application will keep track of user searches, allowing them to access and modify their older preferences through a user login functionality.
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


