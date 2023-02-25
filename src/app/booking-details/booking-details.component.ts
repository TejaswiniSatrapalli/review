import { Component } from '@angular/core';
import { BookingDTO } from '../booking-dto';
import { BookingOperationService } from '../booking-operation.service';

@Component({
  selector: 'app-booking-details',
  templateUrl: './booking-details.component.html',
  styleUrls: ['./booking-details.component.css']
})
export class BookingDetailsComponent {

  allBookings:BookingDTO [] = [];
  constructor(private orderService:BookingOperationService)
  {
    orderService.getAllBookingFromSpring().subscribe(
      data=>{
          this.allBookings = data;
      },
      err=>{
        console.log("Error "+err);
        
      }
    );
  }


}
