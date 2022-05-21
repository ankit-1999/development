import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TeacherService } from '../service/teacher.service';

@Component({
  selector: 'app-teacher-view',
  templateUrl: './teacher-view.component.html',
  styleUrls: ['./teacher-view.component.css'],
})
export class TeacherViewComponent implements OnInit {
  
  students: any;

  constructor(private router: Router, private teacher: TeacherService) {
    teacher.getStudents().subscribe((data) => {
      this.students = data;
      
    });
  }

  deleteStudent(id:any) {
    this.teacher.deleteStudent(id).subscribe(()=>{
      
    })
    window.location.reload();
    alert('Student deleted successfully');
    
  }

  editStudent(id:any)
  {
    this.teacher.id = id;
    this.router.navigateByUrl('/editStudent');
  }

  navigateToAddStudent() {
    this.router.navigateByUrl('addStudent');
  }

  ngOnInit(): void {}
}
