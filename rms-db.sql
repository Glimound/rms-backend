--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE IF EXISTS rms_db;
--
-- Name: rms_db; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE rms_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Chinese (Simplified)_China.936';


ALTER DATABASE rms_db OWNER TO postgres;

\connect rms_db

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE rms_db; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE rms_db IS '科研管理系统数据库';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    client_name character varying(100) NOT NULL,
    address character varying(500) NOT NULL,
    superintendent_id integer NOT NULL
);


ALTER TABLE public.client OWNER TO postgres;

--
-- Name: TABLE client; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.client IS '委托方表';


--
-- Name: client_contact; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client_contact (
    contact_id integer NOT NULL,
    name character varying(100) NOT NULL,
    office_phone character varying(100) NOT NULL,
    mobile_phone character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    client_name character varying(100) NOT NULL
);


ALTER TABLE public.client_contact OWNER TO postgres;

--
-- Name: TABLE client_contact; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.client_contact IS '委托方联系人表';


--
-- Name: client_contact_contact_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.client_contact_contact_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.client_contact_contact_id_seq OWNER TO postgres;

--
-- Name: client_contact_contact_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.client_contact_contact_id_seq OWNED BY public.client_contact.contact_id;


--
-- Name: collaborator; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.collaborator (
    collaborator_name character varying(100) NOT NULL,
    address character varying(500) NOT NULL,
    superintendent_id integer NOT NULL
);


ALTER TABLE public.collaborator OWNER TO postgres;

--
-- Name: TABLE collaborator; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.collaborator IS '合作方表';


--
-- Name: collaborator_contact; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.collaborator_contact (
    contact_id integer NOT NULL,
    name character varying(100) NOT NULL,
    office_phone character varying(100) NOT NULL,
    mobile_phone character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    collaborator_name character varying(100) NOT NULL
);


ALTER TABLE public.collaborator_contact OWNER TO postgres;

--
-- Name: TABLE collaborator_contact; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.collaborator_contact IS '合作方联系人表';


--
-- Name: collaborator_contact_contact_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.collaborator_contact_contact_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.collaborator_contact_contact_id_seq OWNER TO postgres;

--
-- Name: collaborator_contact_contact_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.collaborator_contact_contact_id_seq OWNED BY public.collaborator_contact.contact_id;


--
-- Name: director; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.director (
    lab_name character varying(100) NOT NULL,
    researcher_id character varying(100) NOT NULL,
    appointment_date date NOT NULL,
    term_date date NOT NULL
);


ALTER TABLE public.director OWNER TO postgres;

--
-- Name: TABLE director; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.director IS '主任表';


--
-- Name: office_space; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.office_space (
    site_id character varying(100) NOT NULL,
    space_area numeric(10,1) NOT NULL,
    address character varying(500) NOT NULL,
    lab_name character varying(500)
);


ALTER TABLE public.office_space OWNER TO postgres;

--
-- Name: TABLE office_space; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.office_space IS '办公场地表';


--
-- Name: project_collaborator; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_collaborator (
    project_id character varying(100) NOT NULL,
    collaborator_name character varying(100) NOT NULL
);


ALTER TABLE public.project_collaborator OWNER TO postgres;

--
-- Name: TABLE project_collaborator; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.project_collaborator IS '项目合作方表';


--
-- Name: quality_monitor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.quality_monitor (
    quality_monitor_name character varying(100) NOT NULL,
    address character varying(500) NOT NULL,
    superintendent_id integer NOT NULL
);


ALTER TABLE public.quality_monitor OWNER TO postgres;

--
-- Name: TABLE quality_monitor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.quality_monitor IS '质量监测方表';


--
-- Name: quality_monitor_contact; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.quality_monitor_contact (
    contact_id integer NOT NULL,
    name character varying(100) NOT NULL,
    office_phone character varying(100) NOT NULL,
    mobile_phone character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    quality_monitor_name character varying(100) NOT NULL
);


ALTER TABLE public.quality_monitor_contact OWNER TO postgres;

--
-- Name: TABLE quality_monitor_contact; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.quality_monitor_contact IS '质量监测方联系人表';


--
-- Name: quality_monitor_contact_contact_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.quality_monitor_contact_contact_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.quality_monitor_contact_contact_id_seq OWNER TO postgres;

--
-- Name: quality_monitor_contact_contact_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.quality_monitor_contact_contact_id_seq OWNED BY public.quality_monitor_contact.contact_id;


--
-- Name: research_achievement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.research_achievement (
    achievement_id integer NOT NULL,
    achievement_name character varying(100) NOT NULL,
    acquisition_date date NOT NULL,
    achievement_type smallint NOT NULL,
    patent_type smallint,
    project_id character varying(100) NOT NULL
);


ALTER TABLE public.research_achievement OWNER TO postgres;

--
-- Name: TABLE research_achievement; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.research_achievement IS '科研成果表';


--
-- Name: COLUMN research_achievement.achievement_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.research_achievement.achievement_type IS '1为专利，2为论文，3为软件著作权';


--
-- Name: COLUMN research_achievement.patent_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.research_achievement.patent_type IS '1为发明，2为实用新型，3为外观';


--
-- Name: research_achievement_achievement_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.research_achievement_achievement_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.research_achievement_achievement_id_seq OWNER TO postgres;

--
-- Name: research_achievement_achievement_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.research_achievement_achievement_id_seq OWNED BY public.research_achievement.achievement_id;


--
-- Name: research_laboratory; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.research_laboratory (
    lab_name character varying(100) NOT NULL,
    research_direction character varying(500) NOT NULL,
    secretary_id character varying(100)
);


ALTER TABLE public.research_laboratory OWNER TO postgres;

--
-- Name: TABLE research_laboratory; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.research_laboratory IS '研究室表';


--
-- Name: research_project; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.research_project (
    project_id character varying(100) NOT NULL,
    project_name character varying(100) NOT NULL,
    project_content text NOT NULL,
    funding numeric(12,2) NOT NULL,
    start_date date NOT NULL,
    complete_date date,
    superintendent_id integer NOT NULL,
    client_name character varying(100),
    quality_monitor_name character varying(100)
);


ALTER TABLE public.research_project OWNER TO postgres;

--
-- Name: TABLE research_project; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.research_project IS '科研项目表';


--
-- Name: researcher_achievement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.researcher_achievement (
    achievement_id integer NOT NULL,
    researcher_id character varying(100) NOT NULL,
    rank smallint NOT NULL
);


ALTER TABLE public.researcher_achievement OWNER TO postgres;

--
-- Name: TABLE researcher_achievement; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.researcher_achievement IS '贡献人表';


--
-- Name: researcher_project; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.researcher_project (
    project_id character varying(100) NOT NULL,
    researcher_id character varying(100) NOT NULL,
    join_date date NOT NULL,
    work_hour integer NOT NULL,
    available_funding numeric(12,2) NOT NULL,
    subtopic_num character varying(100)
);


ALTER TABLE public.researcher_project OWNER TO postgres;

--
-- Name: TABLE researcher_project; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.researcher_project IS '参与科研项目表，记录人员参加科研项目的信息';


--
-- Name: scientific_researcher; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.scientific_researcher (
    researcher_id character varying(100) NOT NULL,
    name character varying(100) NOT NULL,
    gender smallint NOT NULL,
    birth date NOT NULL,
    title character varying(100) NOT NULL,
    research_direction character varying(500) NOT NULL,
    lab_name character varying(100)
);


ALTER TABLE public.scientific_researcher OWNER TO postgres;

--
-- Name: TABLE scientific_researcher; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.scientific_researcher IS '科研人员表';


--
-- Name: COLUMN scientific_researcher.gender; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.scientific_researcher.gender IS '1是男，2是女';


--
-- Name: secretary; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.secretary (
    secretary_id character varying(100) NOT NULL,
    name character varying(100) NOT NULL,
    gender smallint NOT NULL,
    birth date NOT NULL,
    employ_date date NOT NULL,
    remit text NOT NULL
);


ALTER TABLE public.secretary OWNER TO postgres;

--
-- Name: TABLE secretary; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.secretary IS '秘书表';


--
-- Name: COLUMN secretary.gender; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.secretary.gender IS '1是男，2是女';


--
-- Name: subtopic; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.subtopic (
    project_id character varying(100) NOT NULL,
    subtopic_num character varying(100) NOT NULL,
    subtopic_content text NOT NULL,
    available_funding numeric(12,2) NOT NULL,
    complete_deadline_date date NOT NULL,
    technical_indicator text NOT NULL,
    superintendent_id integer NOT NULL
);


ALTER TABLE public.subtopic OWNER TO postgres;

--
-- Name: TABLE subtopic; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.subtopic IS '子课题表';


--
-- Name: superintendent; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.superintendent (
    superintendent_id integer NOT NULL,
    name character varying(100) NOT NULL,
    office_phone character varying(100) NOT NULL,
    mobile_phone character varying(100) NOT NULL,
    email character varying(100) NOT NULL
);


ALTER TABLE public.superintendent OWNER TO postgres;

--
-- Name: TABLE superintendent; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.superintendent IS '负责人表';


--
-- Name: superintendent_superintendent_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.superintendent_superintendent_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.superintendent_superintendent_id_seq OWNER TO postgres;

--
-- Name: superintendent_superintendent_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.superintendent_superintendent_id_seq OWNED BY public.superintendent.superintendent_id;


--
-- Name: client_contact contact_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client_contact ALTER COLUMN contact_id SET DEFAULT nextval('public.client_contact_contact_id_seq'::regclass);


--
-- Name: collaborator_contact contact_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collaborator_contact ALTER COLUMN contact_id SET DEFAULT nextval('public.collaborator_contact_contact_id_seq'::regclass);


--
-- Name: quality_monitor_contact contact_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quality_monitor_contact ALTER COLUMN contact_id SET DEFAULT nextval('public.quality_monitor_contact_contact_id_seq'::regclass);


--
-- Name: research_achievement achievement_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.research_achievement ALTER COLUMN achievement_id SET DEFAULT nextval('public.research_achievement_achievement_id_seq'::regclass);


--
-- Name: superintendent superintendent_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.superintendent ALTER COLUMN superintendent_id SET DEFAULT nextval('public.superintendent_superintendent_id_seq'::regclass);


--
-- Name: client_contact client_contact_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client_contact
    ADD CONSTRAINT client_contact_pk PRIMARY KEY (contact_id);


--
-- Name: client client_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pk PRIMARY KEY (client_name);


--
-- Name: collaborator_contact collaborator_contact_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collaborator_contact
    ADD CONSTRAINT collaborator_contact_pk PRIMARY KEY (contact_id);


--
-- Name: collaborator collaborator_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collaborator
    ADD CONSTRAINT collaborator_pk PRIMARY KEY (collaborator_name);


--
-- Name: director director_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.director
    ADD CONSTRAINT director_pk PRIMARY KEY (lab_name);


--
-- Name: director director_pk2; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.director
    ADD CONSTRAINT director_pk2 UNIQUE (researcher_id);


--
-- Name: office_space office_space_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.office_space
    ADD CONSTRAINT office_space_pk PRIMARY KEY (site_id);


--
-- Name: project_collaborator project_collaborator_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_collaborator
    ADD CONSTRAINT project_collaborator_pk PRIMARY KEY (project_id, collaborator_name);


--
-- Name: quality_monitor_contact quality_monitor_contact_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quality_monitor_contact
    ADD CONSTRAINT quality_monitor_contact_pk PRIMARY KEY (contact_id);


--
-- Name: quality_monitor quality_monitor_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quality_monitor
    ADD CONSTRAINT quality_monitor_pk PRIMARY KEY (quality_monitor_name);


--
-- Name: research_achievement research_achievement_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.research_achievement
    ADD CONSTRAINT research_achievement_pk PRIMARY KEY (achievement_id);


--
-- Name: research_achievement research_achievement_pk2; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.research_achievement
    ADD CONSTRAINT research_achievement_pk2 UNIQUE (achievement_name);


--
-- Name: research_laboratory research_laboratory_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.research_laboratory
    ADD CONSTRAINT research_laboratory_pk PRIMARY KEY (lab_name);


--
-- Name: research_project research_project_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.research_project
    ADD CONSTRAINT research_project_pk PRIMARY KEY (project_id);


--
-- Name: researcher_achievement researcher_achievement_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.researcher_achievement
    ADD CONSTRAINT researcher_achievement_pk PRIMARY KEY (achievement_id, researcher_id);


--
-- Name: researcher_achievement researcher_achievement_pk2; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.researcher_achievement
    ADD CONSTRAINT researcher_achievement_pk2 UNIQUE (achievement_id, rank);


--
-- Name: researcher_project researcher_project_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.researcher_project
    ADD CONSTRAINT researcher_project_pk PRIMARY KEY (project_id, researcher_id);


--
-- Name: scientific_researcher scientific_researcher_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.scientific_researcher
    ADD CONSTRAINT scientific_researcher_pk PRIMARY KEY (researcher_id);


--
-- Name: secretary secretary_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secretary
    ADD CONSTRAINT secretary_pk PRIMARY KEY (secretary_id);


--
-- Name: subtopic subtopic_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.subtopic
    ADD CONSTRAINT subtopic_pk PRIMARY KEY (project_id, subtopic_num);


--
-- Name: superintendent superintendent_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.superintendent
    ADD CONSTRAINT superintendent_pk PRIMARY KEY (superintendent_id);


--
-- Name: client_contact client_contact_client_client_name_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client_contact
    ADD CONSTRAINT client_contact_client_client_name_fk FOREIGN KEY (client_name) REFERENCES public.client(client_name) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: client client_superintendent_superintendent_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_superintendent_superintendent_id_fk FOREIGN KEY (superintendent_id) REFERENCES public.superintendent(superintendent_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: collaborator_contact collaborator_contact_collaborator_collaborator_name_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collaborator_contact
    ADD CONSTRAINT collaborator_contact_collaborator_collaborator_name_fk FOREIGN KEY (collaborator_name) REFERENCES public.collaborator(collaborator_name) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: collaborator collaborator_superintendent_superintendent_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collaborator
    ADD CONSTRAINT collaborator_superintendent_superintendent_id_fk FOREIGN KEY (superintendent_id) REFERENCES public.superintendent(superintendent_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: director director_research_laboratory_lab_name_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.director
    ADD CONSTRAINT director_research_laboratory_lab_name_fk FOREIGN KEY (lab_name) REFERENCES public.research_laboratory(lab_name) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: director director_scientific_researcher_researcher_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.director
    ADD CONSTRAINT director_scientific_researcher_researcher_id_fk FOREIGN KEY (researcher_id) REFERENCES public.scientific_researcher(researcher_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: office_space office_space_research_laboratory_lab_name_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.office_space
    ADD CONSTRAINT office_space_research_laboratory_lab_name_fk FOREIGN KEY (lab_name) REFERENCES public.research_laboratory(lab_name) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- Name: project_collaborator project_collaborator_collaborator_collaborator_name_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_collaborator
    ADD CONSTRAINT project_collaborator_collaborator_collaborator_name_fk FOREIGN KEY (collaborator_name) REFERENCES public.collaborator(collaborator_name) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: project_collaborator project_collaborator_research_project_project_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_collaborator
    ADD CONSTRAINT project_collaborator_research_project_project_id_fk FOREIGN KEY (project_id) REFERENCES public.research_project(project_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: quality_monitor_contact quality_monitor_contact_quality_monitor_quality_monitor_name_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quality_monitor_contact
    ADD CONSTRAINT quality_monitor_contact_quality_monitor_quality_monitor_name_fk FOREIGN KEY (quality_monitor_name) REFERENCES public.quality_monitor(quality_monitor_name) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: quality_monitor quality_monitor_superintendent_superintendent_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quality_monitor
    ADD CONSTRAINT quality_monitor_superintendent_superintendent_id_fk FOREIGN KEY (superintendent_id) REFERENCES public.superintendent(superintendent_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: research_achievement research_achievement_research_project_project_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.research_achievement
    ADD CONSTRAINT research_achievement_research_project_project_id_fk FOREIGN KEY (project_id) REFERENCES public.research_project(project_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: research_laboratory research_laboratory_secretary_secretary_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.research_laboratory
    ADD CONSTRAINT research_laboratory_secretary_secretary_id_fk FOREIGN KEY (secretary_id) REFERENCES public.secretary(secretary_id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- Name: research_project research_project_client_client_name_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.research_project
    ADD CONSTRAINT research_project_client_client_name_fk FOREIGN KEY (client_name) REFERENCES public.client(client_name) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- Name: research_project research_project_quality_monitor_quality_monitor_name_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.research_project
    ADD CONSTRAINT research_project_quality_monitor_quality_monitor_name_fk FOREIGN KEY (quality_monitor_name) REFERENCES public.quality_monitor(quality_monitor_name) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- Name: research_project research_project_superintendent_superintendent_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.research_project
    ADD CONSTRAINT research_project_superintendent_superintendent_id_fk FOREIGN KEY (superintendent_id) REFERENCES public.superintendent(superintendent_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: researcher_achievement researcher_achievement_research_achievement_achievement_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.researcher_achievement
    ADD CONSTRAINT researcher_achievement_research_achievement_achievement_id_fk FOREIGN KEY (achievement_id) REFERENCES public.research_achievement(achievement_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: researcher_achievement researcher_achievement_scientific_researcher_researcher_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.researcher_achievement
    ADD CONSTRAINT researcher_achievement_scientific_researcher_researcher_id_fk FOREIGN KEY (researcher_id) REFERENCES public.scientific_researcher(researcher_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: researcher_project researcher_project_research_project_project_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.researcher_project
    ADD CONSTRAINT researcher_project_research_project_project_id_fk FOREIGN KEY (project_id) REFERENCES public.research_project(project_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: researcher_project researcher_project_scientific_researcher_researcher_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.researcher_project
    ADD CONSTRAINT researcher_project_scientific_researcher_researcher_id_fk FOREIGN KEY (researcher_id) REFERENCES public.scientific_researcher(researcher_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: researcher_project researcher_project_subtopic_subtopic_num_project_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.researcher_project
    ADD CONSTRAINT researcher_project_subtopic_subtopic_num_project_id_fk FOREIGN KEY (subtopic_num, project_id) REFERENCES public.subtopic(subtopic_num, project_id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- Name: scientific_researcher scientific_researcher_research_laboratory_lab_name_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.scientific_researcher
    ADD CONSTRAINT scientific_researcher_research_laboratory_lab_name_fk FOREIGN KEY (lab_name) REFERENCES public.research_laboratory(lab_name) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- Name: subtopic subtopic_research_project_project_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.subtopic
    ADD CONSTRAINT subtopic_research_project_project_id_fk FOREIGN KEY (project_id) REFERENCES public.research_project(project_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: subtopic subtopic_superintendent_superintendent_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.subtopic
    ADD CONSTRAINT subtopic_superintendent_superintendent_id_fk FOREIGN KEY (superintendent_id) REFERENCES public.superintendent(superintendent_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

