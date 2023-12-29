**City Weather Comparison Tool**

**OpenWeather API:** [[https://www.statcan.gc.ca/en/microdata/api](https://openweathermap.org/)]

**OpenWeatherAPI Postman Link** https://www.postman.com/alex-postman-workspace/workspace/openweather-api/overview

**Project Discord:** [ Discord ](https://discord.gg/Vnf28JWz)

## Problem Domain

Our team aims to develop an application that assists users interested in immigratation to a particular city to compare the weather of their cities of interest  This tool is based on a model that calculates ideal weather  scores for each city of interest using data from the openWeather API.

## Application Description

Our application will offer users a user-friendly interface to input their current cities of interest for immigration and provide them with a comparison tool based on their own preferences for perfect weather conditions (weighting variables that form the basis of our calculation of the perfect weather). The application will then gather relevant data from the OpenWeather API to calculate a perfect weather score for each city of interest and display it graphically based on our existing model in a way that is meaningful to the user. These scores will be used to offer recommendations on which one of the cities of interest might be the best fit for the user's needs. Additionally, this application will keep track of user searches, allowing them to access and modify their older preferences through a user login functionality.
## API Documentation

We will utilize the [Statistics Canada API](https://www.statcan.gc.ca/eng/developers/wds/rest) to access demographic and economic data for Canadian provinces.

## Example Calls to API and Data Output

<img width="960" alt="API-Test-Call" src="https://github.com/kiarashkianid/Weather-Wanderer/assets/144408744/bc8d3e0d-86d2-4bae-8e56-8cbeff28fcc6">


## Example Java Code Calling the API

Located in: "src/main/java/api/StatsCanada.java". Modelled after the Grade API lab activity, using OkHttp.


## Some possible technical challenges that might block progress
- Not exactly a technical issue; our 4th member, Matthew MacQuarrie-Cottle has been unable to join the repository as a collaborator yet, we will get this sorted on Monday. 
- one of the possible challenges is data management and processing from an API that is updating over time
- Learning curve of extracting the data from the API & getting it into IntelliJ (our test API sample call only checks for if the call was successful; we aren't quite sure how to extract the data yet.)

# Group Notes

## Stories

Story 1:
A biologist is looking for the coldest & snowiest major city to do some research. They can enter different major cities and compare which cities have the coldest weather & the most amount of snowy days to decide which city would have the ideal conditions for their work.

Story 2:
A sailor is looking to move to a city with good wind speeds to be able to sail often. They sign up & enter their preference that they want great wind speeds, a reasonable temperature, and minimal rainy days. Then, they pick the city they are currently located in, and the different cities that they are planning on moving to until they find a good match.

Story 3: 
A person got job offer as a marine biologist to do fieldwork. However, they must move to either New York or California. They input the two cities and compare the temperature, wind speeds, & rainy days, all of which will affect their work in different ways. The app will then compare these parameters between the two cities so that they can make an educated decision.

Story 4:
A person has high sensitivity to sunlight & needs a clowdy city to live in. They sign up on the app, & compare cities with a high preference for cloudy days & little preference for anything else. The person can filter through each of the major cities until they find the cloudiest city to move to.

Team story:
A person wants to move & is interested in the weather in a few different major cities. They want to compare the temperature, % of rainy days, & % of snowy days. They will input the city they currently live in & the city they want to move to & the application will compare and give scores for the relevant data.



