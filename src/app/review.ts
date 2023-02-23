export class Review {
    reviewId : number;
    hotelId:number;
    // userName:string;
    starRating : number;
	userReviewMsge : string;


    constructor( 
       
    reviewId : number,
    hotelId:number,
	starRating : number,
	userReviewMsge : string,

   
    ){

        this. reviewId= reviewId;
        // this.userName=userName;
        this.hotelId=hotelId;
        this.starRating=starRating;
        this.userReviewMsge=userReviewMsge;
       
    }
}
