import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from './review';
import { ReviewDTO } from './review-dto';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  
  baseURL:string = 'http://localhost:2004';

  submitReviewEndPoint:string=this.baseURL+'/review/addReview';

  allReviewsEndPoint : string= this.baseURL+'/review/reviews';

  ratingsForHotelEndPoint:string = this.baseURL+'/review/ratings/${starRating}'

  ReviewByHotelIdEndPoint:string=this.baseURL+'/review/hotel/${hotelId}';
  
  constructor(private http:HttpClient) { }

  getReviewByHotelId(hotelId:number):Observable<ReviewDTO[]>
  {
    console.log("inside method 1"+this.ReviewByHotelIdEndPoint);
    this.ReviewByHotelIdEndPoint = this.ReviewByHotelIdEndPoint+'/'+hotelId;
    console.log("after getting review 2"+this.ReviewByHotelIdEndPoint);

    return this.http.get<ReviewDTO[]>(`${this.ReviewByHotelIdEndPoint}`);
  }

  getRatingsByHotelId(filterReviewbyrating:number):Review[]
    {
      return[];
    }

  submitReview(review:Review):Observable<Review>
  {
    console.log("inside method 1 : Review added"+review);

    return this.http.post<Review>(`${this.submitReviewEndPoint}`,review);
  }

  getAllReviewsFromSpring():Observable<ReviewDTO[]>
  {
    console.log("inside service : "+this.allReviewsEndPoint);

    return this.http.get<ReviewDTO[]>(`${this.allReviewsEndPoint}`);
  }

}

 


