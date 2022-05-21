import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {StudentServiceService} from '../service/student-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student-view',
  templateUrl: './student-view.component.html',
  styleUrls: ['./student-view.component.css']
})
export class StudentViewComponent implements OnInit {

  constructor( private router: Router,private studentService:StudentServiceService) {

  }

  student: any;

  getData(data:any) {
    this.studentService.getStudent(data.rollNo).subscribe((result) => {
      this.student=result;
       if(this.student[0].name!=data.name){
         alert("invalid rollNo or name");
       }
       else
       {
         this.studentService.rollNo=data.rollNo;
         this.router.navigateByUrl('studentResult');
       }
    },error=>{
      alert("invalid rollNo or name");
    })
  }


  ngOnInit(): void {
  }

}
