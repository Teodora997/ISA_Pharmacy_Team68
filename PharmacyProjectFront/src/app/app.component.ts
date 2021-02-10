import { Component, OnInit } from '@angular/core';
import { WorkTime } from './work-time';
import { WorkTimeService } from './work-time.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'pharmacyProjectFront';

  public worktime: WorkTime[] = [] ;

  constructor(private worktimeservice:WorkTimeService){}
  public getWorkTimes():void{
    this.worktimeservice.getWorkTimes().subscribe(
    (
      response:WorkTime[])=>{
        this.worktime=response;
      }
    
    )
  }
  ngOnInit(){
    this.getWorkTimes();
  }
}
