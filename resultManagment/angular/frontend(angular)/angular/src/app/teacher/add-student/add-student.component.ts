import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { TeacherService } from '../service/teacher.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css'],
})
export class AddStudentComponent implements OnInit {
  constructor(private teacher: TeacherService, private router: Router) {}

  validate(data: any) {
    if (
      data.rollNo == '' ||
      data.name == '' ||
      data.dateOfBirth == '' ||
      data.score == ''
    ) {
      alert('please fill all input fields');
      return false;
    }
    return true;
  }

  getData(data: NgForm) {
    console.log('start of  data');
    if (this.validate(data) == true) {
      this.teacher.saveStudent(data).subscribe((result) => {
        console.warn(data);
      });
      alert('Student added successfully');
      this.router.navigate(['/teacher']);
    }
    console.log('end of getdata');
  }

  validateRollNo(rollNo: any): boolean {
    this.teacher.getstudent(rollNo).subscribe((result) => {
      alert('RollNo already exists , Please enter another rollNo');
      return true;
    });
    return false;
  }

  ngOnInit(): void {}
}
