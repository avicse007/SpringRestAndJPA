# SpringRestAndJPA

## Read Building+a+REST+API+with+Spring.pdf for a warm up 

This repo explains the basic of JPA and SpringRest from a course 

1. http://localhost:8080/tours?size=3&page=1&sort=title,desc
2. http://localhost:8080/tours/search/findByTourPackageCode?code=SC
3. http://localhost:8080/tours/search
4. http://localhost:8080/tours/
5. http://localhost:8080/tourPackages/search/findByName?name=Backpack%20Cal
6. http://localhost:8080/tourPackages/search
7. http://localhost:8080/tourPackages/CC
8. http://localhost:8080/tours/1/tourPackage
9. http://localhost:8080/tours/1
10. http://localhost:8080/
11. DELETE http://localhost:8080/packages/CC
12. http://localhost:8080/packages/CC
13. POST http://localhost:8080/tours/1/ratings/   Body {
	"score" : "5",
	"comment" : "It was Great !!!!",
	"customerId": "1"
}
14. http://localhost:8080/tours/1/ratings
15. http://localhost:8080/tours/1/ratings/average
16. PUT http://localhost:8080/tours/1/ratings/ Body {
	"score" : "3",
	"comment" : "It was average !!!!",
	"customerId": "1"
}

17. PATCH http://localhost:8080/tours/1/ratings/ Body  {
	"comment" : "It was average :(",
	"customerId": "1"
}

18. DELETE http://localhost:8080/tours/1/ratings/1

19. http://localhost:8080/tours/1/ratings?size=3&page=1&sort=score,asc

20. Check for Embedding HyperMedia link in Spring HATEOS project to learn
how to embed hypermedia into your rest controller



13. DTO :
========== 
Data transfer object . This is used when the data get by the request is not same a the backing class. 
Here the cilent will not send the whole Tour Object for creating a TourRating object so we need to 
create a Data Transfer object (DTO). So here we aew creating RatingDto




