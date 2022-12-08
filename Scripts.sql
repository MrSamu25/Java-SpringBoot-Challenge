-- delete all
DROP TABLE IF EXISTS public."user", public."album",  public."shared_album" CASCADE;

---------------------------------------------------------

DROP TABLE IF EXISTS public."user";

CREATE TABLE IF NOT EXISTS public."user"
(
id SERIAL NOT NULL,
name character varying,
username character varying ,
email character varying,
phone character varying ,
website character varying,
CONSTRAINT "User_pkey" PRIMARY KEY (id)
)

select * from public."user";

---------------------------------------------------------

DROP TABLE IF EXISTS public."album";

CREATE TABLE IF NOT EXISTS public."album"
(
id SERIAL NOT NULL,
userid int NOT NULL,
title character varying,
PRIMARY KEY (id),
CONSTRAINT "User_pkey" FOREIGN KEY (userid)
REFERENCES public."user"(id)
)

select * from public."album";

---------------------------------------------------------

DROP TABLE IF EXISTS public."shared_album";

CREATE TABLE IF NOT EXISTS public."shared_album"
(
id SERIAL NOT NULL,
read boolean NOT NULL,
write boolean NOT NULL,
useridsource int NOT NULL,
useriddestination int NOT NULL,
albumid int NOT NULL,
PRIMARY KEY (id),
CONSTRAINT User_pkey_source FOREIGN KEY (useridsource)
REFERENCES public."user"(id),
CONSTRAINT User_pkey_destination FOREIGN KEY (useriddestination)
REFERENCES public."user"(id),
CONSTRAINT Album_pkey FOREIGN KEY (albumid)
REFERENCES public."album"(id)
)

select * from public."shared_album";

select * from public."shared_album" where albumid = 11 and read = false;

