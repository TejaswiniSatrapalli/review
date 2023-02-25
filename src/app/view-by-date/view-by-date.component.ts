import { Component } from '@angular/core';
import { BookingDTO } from '../booking-dto';
import { BookingOperationService } from '../booking-operation.service';

@Component({
  selector: 'app-view-by-date',
  templateUrl: './view-by-date.component.html',
  styleUrls: ['./view-by-date.component.css']
})
export class ViewByDateComponent {

  allBooking:BookingDTO[]=[];

  constructor(private bookingService:BookingOperationService)
  {

    console.log("All Bookings")
    bookingService.getAllBookingFromSpring().subscribe(
      data=>{
        this.allBooking=data;
      },
      err=>{
        console.log("Error"+err);
      }
    );
  }

  
  getBooking2(bookedFrom:string){
    this.bookingService.getBookingBydate(bookedFrom).subscribe(
      data=>{
        console.log("data :- "+data);
        
        this.allBooking = data;
      },err=>{
        console.log("error from spring ",err);
  
      } 
    );
  }

}



