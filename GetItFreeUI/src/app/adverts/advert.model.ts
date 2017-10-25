export class AdvertModel{
  public id: number;
  public head: string;
  public content: string;
  public date: Date;
  public imageUrl: string;


  constructor(id: number, head: string, content: string, date: Date, imageUrl: string) {
    this.id = id;
    this.head = head;
    this.content = content;
    this.date = date;
    this.imageUrl = imageUrl;
  }
}
