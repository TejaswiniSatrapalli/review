import { Component } from '@angular/core';
import { Booking } from '../booking';
import { BookingDTO } from '../booking-dto';
import { BookingOperationService } from '../booking-operation.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent {

  today: string = new Date().toISOString().slice(0, 10);
  
  model: Booking = new Booking(0,'',0,0,0,0,0,0,0);
  submitted = false;
  success = false;
  error = false;
  
  status = false;
  message = '';

  allBookings:BookingDTO[]=[]

  constructor(private bookingService:BookingOperationService) {}

  onSubmit() {
    this.bookingService.addBooking(this.model).subscribe(

      data=>{
        this.status=true;
        this.message="Booking submitted";

      },
      error=>{

      }

    );

    

   
  }


}


