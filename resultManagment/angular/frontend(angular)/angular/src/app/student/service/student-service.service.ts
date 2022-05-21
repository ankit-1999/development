import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  rollNo: any;

  constructor(private http: HttpClient) { 

  }

  getStudent(id:any){
    return this.http.get('http://localhost:4000/student/'+id); 
    
  }

}


