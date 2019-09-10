import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { AddCommentDTO } from 'src/app/model/add-comment-dto';
import { Observable } from 'rxjs';
import { Comment } from 'src/app/model/comment';
import { RatingDTO } from 'src/app/model/rating-dto';
import { PublishCommentDTO } from 'src/app/model/publish-comment-dto';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
const srcResUrl="http://localhost:8763/srcres/api/rating/"

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  private sendCommentUrl=srcResUrl+"sendComment";
  private getAllCommentsUrl=srcResUrl+"getAllComments";
  private publishCommentUrl=srcResUrl+"publishComment";
  private sendRatingUrl=srcResUrl+"newRating";
  private hajdeUrl=srcResUrl+"hajde";
  private commentsForFacilityUrl=srcResUrl+"getForFacility/"

  constructor(private http:HttpClient) { }

  sendComment(comment:AddCommentDTO):Observable<any>{
    return this.http.post<any>(this.sendCommentUrl,comment,httpOptions);
  }

  getAllComments():Observable<Comment[]>{
    return this.http.get<Comment[]>(this.getAllCommentsUrl,httpOptions);
  }

  publishComment(dto:PublishCommentDTO):Observable<any>{
    return this.http.post<any>("http://localhost:2222/api/rating/publishComment",dto,httpOptions);
  }

  hajde(dto:PublishCommentDTO):Observable<any>{
    return this.http.post<any>(this.hajdeUrl,dto,httpOptions);
  }

  sendRating(rating:RatingDTO):Observable<any>{
    return this.http.post<any>(this.sendRatingUrl,rating,httpOptions);
  }

  commentsForFacility(id:Number):Observable<Comment[]>{
    let url=this.commentsForFacilityUrl+id;
    return this.http.get<Comment[]>(url,httpOptions);
  }
}
