import { Component, OnInit } from '@angular/core';
import { Review } from '../review';
import { ReviewDTO } from '../review-dto';
import { ReviewService } from '../review.service';

@Component({
  selector: 'app-view-reviews',
  templateUrl: './view-reviews.component.html',
  styleUrls: ['./view-reviews.component.css']
})

export class ViewReviewsComponent    {

allReviews:ReviewDTO[]=[]

  constructor(private reviewService: ReviewService) {

    reviewService.getAllReviewsFromSpring().subscribe(

      data=>{
        this.allReviews=data;
      },
      err=>{
        console.log("Error"+err);
  
      }
    );
    }
  }


