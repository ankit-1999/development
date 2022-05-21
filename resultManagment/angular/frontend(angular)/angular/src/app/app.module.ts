import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from '@angular/common/http'
import { AppComponent } from './app.component';


import { LoginComponent } from './login/login.component';
import {StudentModule} from './student/student.module';
import { TeacherModule} from './teacher/teacher.module';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
   
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TeacherModule,
    StudentModule,
    HttpClientModule,
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
