import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { TeacherViewComponent } from './teacher/teacher-view/teacher-view.component';
import { LoginComponent} from './login/login.component';
import { StudentViewComponent } from './student/student-view/student-view.component';
import {AddStudentComponent} from './teacher/add-student/add-student.component';
import {EditStudentComponent} from './teacher/edit-student/edit-student.component';
import {StudentResultComponent} from './student/student-result/student-result.component'

const routes: Routes = [
  
  {path:'teacher',component: TeacherViewComponent},
  {path:'login',component:LoginComponent},
  {path:'student',component:StudentViewComponent},
  {path:'addStudent',component:AddStudentComponent},
  {path:'editStudent',component:EditStudentComponent},
  {path:'studentResult',component:StudentResultComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
