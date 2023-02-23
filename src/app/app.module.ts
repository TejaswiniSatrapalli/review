import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AboutUsComponent } from './about-us/about-us.component';

import { RoomsComponent } from './rooms/rooms.component';
import { BookingsComponent } from './bookings/bookings.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { ReviewComponent } from './review/review.component';
import { UserComponent } from './user/user.component';
import { HotelComponent } from './hotel/hotel.component';
import { ViewReviewsComponent } from './view-reviews/view-reviews.component';

const allLinks:Routes=[

  {path:'hotels',component:HotelComponent},
  {path:'review',component:ReviewComponent},
  {path:'rooms',component:RoomsComponent},
  {path:'bookings',component:BookingsComponent},
  {path:'transactions',component:TransactionsComponent},
  {path:'about-us',component:AboutUsComponent},
  {path:'viewReviews',component:ViewReviewsComponent},


]


@NgModule({
  declarations: [
    AppComponent,
    AboutUsComponent,
    HotelComponent,
    RoomsComponent,
    BookingsComponent,
    TransactionsComponent,
    HeaderComponent,
    ReviewComponent,
    UserComponent,
    HotelComponent,
    ViewReviewsComponent,
  
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(allLinks),
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
