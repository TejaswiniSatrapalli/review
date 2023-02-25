import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BookingDTO } from './booking-dto';
import { Booking } from './booking';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingOperationService {
  [x: string]: any;

  baseURL:string= 'http://localhost:2020';
  
  allBookingEndpoint:string = this.baseURL+'/booking/bookings';

  submitBookingDetailsEndPoint:string=this.baseURL+'/booking/add';

  getBookingByIdEndPoint:string=this.baseURL+'/booking/bookingId';

  getBookingByDateEndPoint:string=this.baseURL+'/booking/bookedFrom';
  
  bookingArr:BookingDTO[]=[];

  constructor(private http:HttpClient){}

  addBooking(booking:Booking):Observable<Booking>
  {
    console.log("inside method 1 : Booking Added" + booking);

  return this.http.post<Booking>(`${this.submitBookingDetailsEndPoint}`,booking);
  }


  getAllBookingFromSpring():Observable<BookingDTO[]>
  {
    console.log("inside service : "+this. allBookingEndpoint);

    return this.http.get<BookingDTO[]>(`${this. allBookingEndpoint}`);
}

  
getBookingBydate(bookedFrom:string):Observable<BookingDTO[]>{

    console.log("Inside Method 1 " + this.getBookingByDateEndPoint);
    this.getBookingByDateEndPoint = this.getBookingByDateEndPoint + '/' + bookedFrom;
    console.log("After adding date 2 " + this.getBookingByDateEndPoint);

    return this.http.get<BookingDTO[]>(`${this.getBookingByDateEndPoint}`);
  }

  getBookingById(bookingId:number): Observable<BookingDTO[]> {
    console.log("Inside Method 1 " + this.getBookingByIdEndPoint);
    this.getBookingByIdEndPoint = this.getBookingByIdEndPoint + '/' + bookingId;
    console.log("After adding date 2 " + this.getBookingByIdEndPoint);

    return this.http.get<BookingDTO[]>(`${this.getBookingByIdEndPoint}`);
  }
  
}
