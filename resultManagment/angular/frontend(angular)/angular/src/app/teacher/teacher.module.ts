import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';

import { TeacherViewComponent } from './teacher-view/teacher-view.component';
import { HeaderComponent } from './header/header.component';
import { AddStudentComponent } from './add-student/add-student.component';
import { EditStudentComponent } from './edit-student/edit-student.component';


@NgModule({
  declarations: [
    TeacherViewComponent,
    HeaderComponent,
    AddStudentComponent,
    EditStudentComponent
  ],
  imports: [
    CommonModule,
    FormsModule
   
  ],
  exports: [
    TeacherViewComponent,
  ]
})
export class TeacherModule { }
