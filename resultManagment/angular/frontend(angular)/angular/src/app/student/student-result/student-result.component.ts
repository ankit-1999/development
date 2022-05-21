import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {StudentServiceService} from '../service/student-service.service'

@Component({
  selector: 'app-student-result',
  templateUrl: './student-result.component.html',
  styleUrls: ['./student-result.component.css']
})
export class StudentResultComponent implements OnInit {

  student: any;

  constructor(private studentService: StudentServiceService, private router: Router) {
    studentService.getStudent(studentService.rollNo).subscribe((data) => {
      this.student = data;
    //  console.warn(data);
    });
  }

  ngOnInit(): void {
  }

}
