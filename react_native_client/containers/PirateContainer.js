import React from "react";
import { Text, View } from 'react-native';
import {useEffect, useState} from "react";
import PirateList from "../components/PirateList";


export default function PirateContainer() {

    const [pirates, setPirates] = useState([]);

    useEffect(() => {
        getPirates();
    }, []);

    async function getPirates() {
        const res = await fetch('http://localhost:8080/pirates');
        const pirates = await res.json();
        // console.log(pirates);
        setPirates(pirates);
    };

    return (
        <View>
            <PirateList pirates={pirates}/>
        </View>
    );

    
}