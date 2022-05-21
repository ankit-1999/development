import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router'

import { StudentViewComponent } from './student-view/student-view.component';
import { HeaderComponent } from './header/header.component';
import { StudentResultComponent } from './student-result/student-result.component';



@NgModule({
  declarations: [
    StudentViewComponent,
    HeaderComponent,
    StudentResultComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
    
  ],
  exports: [
    StudentViewComponent,
  ]
})
export class StudentModule { }
