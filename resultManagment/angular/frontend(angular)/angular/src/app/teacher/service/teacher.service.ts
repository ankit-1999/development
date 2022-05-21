import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  constructor(private http: HttpClient) {

  }
  
  id:any;

  getStudents(){
      return this.http.get('http://localhost:4000/students');
    }

   saveStudent(data: any){
     return this.http.post('http://localhost:4000/addStudent',data);
   } 

   deleteStudent(id: any){
     return this.http.delete('http://localhost:4000/student/'+id);
   }
   getStudent(){
     return this.http.get('http://localhost:4000/student/'+this.id); 
   }

   getstudent(id:any){
    return this.http.get('http://localhost:4000/student/'+id); 
  }

   updateStudent(data: any){
     return this.http.put('http://localhost:4000/updateStudent',data);
   }
}
