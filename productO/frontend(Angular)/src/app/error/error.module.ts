import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { InternalServerErrorComponent } from './internal-server-error/internal-server-error.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    PageNotFoundComponent,
    InternalServerErrorComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
  ]
})
export class ErrorModule { }
