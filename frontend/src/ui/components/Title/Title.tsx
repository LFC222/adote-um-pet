import { type } from "os";
import { 
TitleStyled,
SubTitle
} from "./style";

interface TitleProps{
    title:string;
    subtitle?:string | JSX.Element;
}

export default function Title(props:TitleProps){
    return (
        <>
            <TitleStyled>{props.title}</TitleStyled>
            <SubTitle>{props.subtitle}</SubTitle>
        </>
    );
}