import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { TeacherService } from '../service/teacher.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css'],
})
export class EditStudentComponent implements OnInit {
  student: any;

  constructor(private teacher: TeacherService, private router: Router) {
    teacher.getStudent().subscribe((data) => {
      this.student = data;
    });
  }

  getData(data: NgForm) {
    this.teacher.updateStudent(data).subscribe((result) => {
      console.warn(result);
    })
    alert("Student updated successfully");
    this.router.navigateByUrl('teacher');
  }

  ngOnInit(): void {}
}
