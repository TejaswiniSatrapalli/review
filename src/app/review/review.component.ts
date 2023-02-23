import { Component } from '@angular/core';
import { Review } from '../review';
import { ReviewDTO } from '../review-dto';
import { ReviewService } from '../review.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent {

  model:Review = new Review(0,0,0,'');
  submitted = false;
  success = false;
  error = false;
  starRating = [1, 2, 3, 4, 5];
  status = false;
  message = '';
  allReviews:ReviewDTO[]=[]

  constructor(private reviewService: ReviewService) {}

    onSubmit() 
    {
    this.reviewService.submitReview(this.model).subscribe(

      data=>{
        this.status=true;
        this.message="flight review submitted";

      },
      error=>{
        console.log("Error"+error);
     }

    );
  
    }
  }




