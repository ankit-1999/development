import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomepageComponent } from './homepage/homepage.component';
import { ErrorModule } from './error/error.module';
import { ToastrModule } from 'ngx-toastr';
import { AuthenticateGuard } from './guard/authenticate/authenticate.guard';

@NgModule({
  declarations: [AppComponent, HomepageComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ErrorModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule,
  ],
  providers: [AuthenticateGuard],
  bootstrap: [AppComponent],
})
export class AppModule {}
